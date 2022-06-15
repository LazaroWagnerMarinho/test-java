package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Inventory(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

  val quantity: Long = 0,

  @JsonManagedReference
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouses_id")
  val warehouses: Warehouses? = null,

  @JsonBackReference
  @OneToMany(mappedBy = "inventory", fetch = FetchType.EAGER)
  val produtoSku: List<ProdutoSku> = emptyList(),

  )
