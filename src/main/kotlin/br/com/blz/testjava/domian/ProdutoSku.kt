package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class ProdutoSku(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val sku: Long = 0,
  val name: String = "",

  @JsonManagedReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inventory_id")
  val inventory: Inventory? = null,

  val isMarketable: Boolean = false

){
}

