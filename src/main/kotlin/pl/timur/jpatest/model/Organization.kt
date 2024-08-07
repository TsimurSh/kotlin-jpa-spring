package pl.timur.jpatest.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table
data class Organization(
    @Id
    val nip: Int,
    val name: String,
    val address: String
) {
    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
    @JsonIgnore
    var employees: List<User> = ArrayList()

    @OneToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    var owner: User? = null
}
