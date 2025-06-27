package com.example.ungdungmuonsachaop.repository;

import com.example.ungdungmuonsachaop.entity.BorrowCode;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, String> {
}
