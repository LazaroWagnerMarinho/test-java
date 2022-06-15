package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Endereco(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

  val locality: String = "",
  val quantity: Int = 0,
  val type: String ="",

  @JsonBackReference
  @ManyToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
  val warehouses: List<Warehouses>? = emptyList(),

//  @JsonBackReference
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "warehouses_id")
//  val warehouses: Warehouses? = null,

)
