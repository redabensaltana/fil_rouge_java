package com.redabens.restosir.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manager", catalog = "restosir")
@Getter
@Setter
@NoArgsConstructor
public class Manager extends User{

}
