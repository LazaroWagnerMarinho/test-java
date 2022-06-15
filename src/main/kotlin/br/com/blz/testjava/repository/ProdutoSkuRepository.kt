package br.com.blz.testjava.repository

import br.com.blz.testjava.domian.Endereco
import br.com.blz.testjava.domian.Inventory
import br.com.blz.testjava.domian.ProdutoSku
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoSkuRepository : JpaRepository<ProdutoSku, Long>

@Repository
interface InventoryRepository : JpaRepository<Inventory, Long>

@Repository
interface EnderecoRepository : JpaRepository<Endereco, Long>
