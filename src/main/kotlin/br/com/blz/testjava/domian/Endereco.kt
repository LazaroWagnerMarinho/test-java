package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Endereco(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,

  val locality: String,
  val quantity: Int,
  val type: String,

  @JsonManagedReference
  @OneToMany(mappedBy = "endereco", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
  var inventory: List<Inventory> = emptyList(),

)
