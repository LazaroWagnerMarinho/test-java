package br.com.blz.testjava.controller

import br.com.blz.testjava.domian.Endereco
import br.com.blz.testjava.domian.Inventory
import br.com.blz.testjava.domian.ProdutoSku
//import br.com.blz.testjava.services.SkuService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SkuController() {
  @GetMapping("/sku")
  fun sku(): List<ProdutoSku> =
//    service.findAllProdutoSku()
  listOf(
    ProdutoSku(
      sku = 43264,
      name = "L'Oréal Professionnel Expert Absolut Repair Cortex Lipidium - Máscara de Reconstrução 500g",
      inventory = inventarioSku()
    )
  )

//  @PostMapping("/sku")
//  fun post(@RequestBody produtoSku: ProdutoSku) = ResponseEntity.ok(service.post(produtoSku))

  fun inventarioSku() : List<Inventory> = listOf(
    Inventory(
      warehouse = endereco(),
    )
  )

  fun endereco() : List<Endereco> = listOf(
    Endereco(
      locality = "SP",
      quantity = 12,
      type = "ECOMMERCE"
    ),
    Endereco(
      locality = "MOEMA",
      quantity = 10,
      type = "PHYSICAL_STORE"
    )
  )
}
