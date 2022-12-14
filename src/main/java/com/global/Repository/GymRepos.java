package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.Entity.Gym;

@Repository
public interface GymRepos extends JpaRepository<Gym, Long> {



}

