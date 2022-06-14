package br.com.blz.testjava.domian

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

//@Entity
@Table(name = "SKU_ENDERECO")
data class Endereco(
//  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//  val id: Long,

  val locality: String,
  val quantity: Int,
  val type: String,

//  @JsonBackReference
//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "inventoty_id")
//  val inventory: Inventory
)
