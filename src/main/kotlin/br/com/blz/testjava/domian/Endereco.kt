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

)
