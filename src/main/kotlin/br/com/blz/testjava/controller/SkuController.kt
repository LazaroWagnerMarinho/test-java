package br.com.blz.testjava.controller

import br.com.blz.testjava.domian.ProdutoSku
import br.com.blz.testjava.repository.EnderecoRepository
import br.com.blz.testjava.repository.InventoryRepository
import br.com.blz.testjava.repository.ProdutoSkuRepository
import br.com.blz.testjava.repository.WarehousesRepository
import br.com.blz.testjava.services.SkuService
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
  fun skuIde(@PathVariable id: Long): Optional<ProdutoSku> = produtoSkuRepository.findById(id)


  @PostMapping("/sku/produto")
  fun post(@RequestBody produtoSku: ProdutoSku) {
    produtoSku.inventory?.warehouses?.endereco?.let { enderecoRepository.save(it) }
    produtoSku.inventory?.warehouses?.let { warehousesRepository.save(it) }
    produtoSku.inventory?.let { inventoryRepository.save(it) }
    produtoSkuRepository.save(produtoSku)
  }

}
