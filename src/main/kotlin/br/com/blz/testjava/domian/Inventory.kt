package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Inventory(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,

  val quantity: Long,

  @JsonManagedReference
  @OneToMany(mappedBy = "inventory", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
  var produtoSku: List<ProdutoSku> = emptyList(),


//  @JsonManagedReference
//  @OneToMany(mappedBy = "warehouses", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
//  val warehouses: List<Endereco> = emptyList(),

)

