package br.com.fiap.Checkpoint2.repository;

import br.com.fiap.Checkpoint2.model.orderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<orderModel, Long> {
}
