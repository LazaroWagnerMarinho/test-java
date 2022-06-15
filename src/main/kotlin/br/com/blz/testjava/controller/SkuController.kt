package br.com.blz.testjava.controller

import br.com.blz.testjava.domian.Inventory
import br.com.blz.testjava.domian.ProdutoSku
import br.com.blz.testjava.repository.EnderecoRepository
import br.com.blz.testjava.repository.InventoryRepository
import br.com.blz.testjava.repository.ProdutoSkuRepository
import br.com.blz.testjava.repository.WarehousesRepository
import br.com.blz.testjava.services.SkuService
import org.springframework.expression.common.ExpressionUtils.toLong
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class SkuController(
  val produtoSkuRepository: ProdutoSkuRepository,
  val inventoryRepository: InventoryRepository,
  val warehousesRepository: WarehousesRepository,
  val enderecoRepository: EnderecoRepository,
  val service: SkuService,
) {
  @GetMapping("/sku")
  fun sku(): List<ProdutoSku> = produtoSkuRepository.findAll()


  @GetMapping("/sku/{id}")
  fun skuIde(@PathVariable id: Long): Optional<ProdutoSku>{
    val produtoDto = produtoSkuRepository.findById(id)
    val idInv = produtoDto.get().inventory?.id
    val inventoryDto = idInv?.let { inventoryRepository.findById(it) }
    val quantityDto = produtoDto.get().inventory?.warehouses?.endereco?.size
    val salve = quantityDto?.let {
      inventoryDto?.orElseThrow{ java.lang.RuntimeException("Id Inventory: $id nao encontrado")}
        ?.copy(quantity = it.toLong())
    }
    inventoryRepository.save(salve)

    return produtoSkuRepository.findById(id)
  }


  @PostMapping("/sku/produto")
  fun post(@RequestBody produtoSku: ProdutoSku) {
    produtoSku.inventory?.warehouses?.endereco?.let { enderecoRepository.saveAll(it) }
    produtoSku.inventory?.warehouses?.let { warehousesRepository.save(it) }
    produtoSku.inventory?.let { inventoryRepository.save(it) }
    if(produtoSku.inventory?.quantity!! > 0){
      val salvar = produtoSku.copy(isMarketable = true)
      produtoSkuRepository.save(salvar)
      return
    }

    produtoSkuRepository.save(produtoSku)
  }

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long): Unit = produtoSkuRepository.deleteById(id)

  @PutMapping("/alter/{id}")
  fun alter(@PathVariable id: Long, @RequestBody produtoSku: ProdutoSku): ResponseEntity<ProdutoSku>{
    val produtoDto = produtoSkuRepository.findById(id)
    val toSalve = produtoDto.orElseThrow{ java.lang.RuntimeException("Sku: $id nao encontrado")}
      .copy(name = produtoSku.name)
    return ResponseEntity.ok(produtoSkuRepository.save(toSalve))
  }

}
