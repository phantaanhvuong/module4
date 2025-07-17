package com.example.kiem_tra_ket_thuc_module_4.repository;

import com.example.kiem_tra_ket_thuc_module_4.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IGiaoDichRepository extends JpaRepository<GiaoDich,Long> {
    @Query("""

            SELECT g FROM GiaoDich g
JOIN g.khachHang k
WHERE (:tenKhachHang = '' OR LOWER(k.tenKhachHang) LIKE LOWER(CONCAT('%', :tenKhachHang, '%')))
  AND (
        :loaiGiaoDich = ''
        OR (:loaiGiaoDich = 'dat' AND g.loaiGiaoDich = false)
        OR (:loaiGiaoDich = 'nha_dat' AND g.loaiGiaoDich = true)
  )
ORDER BY k.tenKhachHang ASC, g.maGiaoDich ASC
""")
    Page<GiaoDich> searchGiaoDich(
            @Param("tenKhachHang") String tenKhachHang,
            @Param("loaiGiaoDich") String loaiGiaoDich,
            Pageable pageable);

    }

