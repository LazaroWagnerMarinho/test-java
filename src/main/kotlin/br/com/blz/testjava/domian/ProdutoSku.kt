package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class ProdutoSku(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val sku: Long,
  val name: String,


  @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "inventory_id")
  val inventory: Inventory?,

  val isMarketable: Boolean

)

