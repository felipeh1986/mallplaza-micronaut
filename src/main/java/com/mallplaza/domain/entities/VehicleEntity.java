package com.mallplaza.domain.entities;

import com.mallplaza.domain.utils.VehicleType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    private UUID id;
    private String patent;
    private VehicleType type;
    private String color;
    private String model;
    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_owner_id", referencedColumnName = "id")
    private VehicleOwnerEntity vehicleOwner;

}
