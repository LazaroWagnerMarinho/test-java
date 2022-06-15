package br.com.blz.testjava.repository

import br.com.blz.testjava.domian.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository : JpaRepository<Livro, Long>
