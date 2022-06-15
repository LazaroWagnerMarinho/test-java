package br.com.blz.testjava.repository

import br.com.blz.testjava.domian.Endereco
import br.com.blz.testjava.domian.Inventory
import br.com.blz.testjava.domian.ProdutoSku
import br.com.blz.testjava.domian.Warehouses
//import br.com.blz.testjava.domian.Warehouses
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SkuRepository: JpaRepository<ProdutoSku, String>

@Repository
interface ProdutoSkuRepository : JpaRepository<ProdutoSku, Long>

@Repository
interface InventoryRepository : JpaRepository<Inventory, Long> {
  fun save(salve: Inventory?)
}

@Repository
interface WarehousesRepository: JpaRepository<Warehouses, Long>

@Repository
interface EnderecoRepository : JpaRepository<Endereco, Long> {
  abstract fun save(it: List<Endereco>): List<Endereco>
}
