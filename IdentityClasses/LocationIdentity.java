package com.soen342.demo.IdentityClasses;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location_")
public class LocationIdentity {
    @Id 
    @Column(name = "location_id") private int location_id;
    @Column(name = "address") private String address;
    @Column(name = "city") private String city;
    @Column(name = "location_name") private String location_name;
    @Column(name = "schedule_id") private int schedule_id;
    @Column(name = "season_id") private int season_id;
}
