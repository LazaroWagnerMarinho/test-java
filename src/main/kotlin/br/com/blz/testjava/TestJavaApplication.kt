package br.com.blz.testjava;

import br.com.blz.testjava.domian.Endereco
import br.com.blz.testjava.domian.Inventory
import br.com.blz.testjava.domian.ProdutoSku
import br.com.blz.testjava.repository.EnderecoRepository
import br.com.blz.testjava.repository.InventoryRepository
import br.com.blz.testjava.repository.ProdutoSkuRepository
import br.com.blz.testjava.repository.SkuRepository
//import br.com.blz.testjava.repository.SkuRepository
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
private class TestJavaApplication

  fun main(args: Array<String>) {
    org.springframework.boot.runApplication<TestJavaApplication>(*args)
  }

@RestController
class SkuController(val produtoSkuRepository: ProdutoSkuRepository, val inventoryRepository: InventoryRepository, val enderecoRepository: EnderecoRepository ) {
  @GetMapping("/sku")
  fun sku(): List<ProdutoSku> = produtoSkuRepository.findAll()

  @GetMapping("/sku/end")
  fun end(): List<Endereco> = enderecoRepository.findAll()

  @GetMapping("/sku/inv")
  fun inv(): List<Inventory> = inventoryRepository.findAll()

//  fun sku(): List<ProdutoSku> = listOf(
//    ProdutoSku(1, 321, "Testando o produto", 543),
//    ProdutoSku(2, 321, "Testando o produto", 543),
//    ProdutoSku(3, 321, "Testando o produto", 543),
//  )
//  fun sku(): List<ProdutoSku> = service.findAllProdutoSku()

  @PostMapping("/sku/produto")
  fun post(@RequestBody produtoSku: ProdutoSku) {
    produtoSku.inventory?.let { inventoryRepository.save(it) }
//    produtoSku.inventory?.warehouses?.let { enderecoRepository.saveAll(it)}
    produtoSkuRepository.save(produtoSku)
  }

  @PostMapping("/sku/inventory")
  fun post(@RequestBody inventory: Inventory) {
    inventoryRepository.save(inventory)
//    inventory.warehouses?.let { enderecoRepository.saveAll(it) }
  }

  @PostMapping("/sku/endereco")
  fun post(@RequestBody endereco: Endereco) {
//    endereco.inventory?.let { inventoryRepository.saveAll(it) }
//    produtoSku.inventory?.warehouses?.let { enderecoRepository.save(it)}
    enderecoRepository.save(endereco)
  }
}
