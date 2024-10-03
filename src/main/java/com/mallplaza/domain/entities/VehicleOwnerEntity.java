package com.mallplaza.domain.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle_owner")
public class VehicleOwnerEntity {

    @Id
    private UUID id;
    private String document;
    private String name;
    private String lastname;
}
