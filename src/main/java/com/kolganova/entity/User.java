package com.kolganova.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "public")
//@Access(AccessType.FIELD)
public class User {
//    @Id
//    @GeneratedValue(generator = "user_gen", strategy = GenerationType.TABLE)
////    @SequenceGenerator(name = "user_gen", sequenceName = "users_id_seq", allocationSize = 1)
//    @TableGenerator(name = "user_gen", table = "all_sequence", allocationSize = 1,
//    pkColumnName = "table_name", valueColumnName = "pk_value")
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date"))
    private PersonalInfo personalInfo;

    @Column(unique = true)
    private String username;

//    @Transient
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date;

}
