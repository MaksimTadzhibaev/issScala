package iss.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "securities")
public class Securities {

    @Id
    @Column
    private String secId;
    @Column
    private String regNumber;
    @Column
    private String name;
    @Column
    private String emitentTitle;
}
