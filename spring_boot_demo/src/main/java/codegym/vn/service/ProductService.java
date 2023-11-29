package codegym.vn.service;

import codegym.vn.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService extends Service<Product> {
    List<Product> findAllByName(String name);
    Page<Product> findAllAndPaging(Pageable pageable);
    Slice<Product> findAllSlice(Pageable pageable);
}
