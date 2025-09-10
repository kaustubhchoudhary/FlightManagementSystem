package system.flight.services;

import system.flight.dto.PaymentsResponseDTO;
import system.flight.entities.Payment;

import java.util.List;

public interface PaymentService {
	
	public List<Payment> getAllPayments();

	public Payment getPaymentById(int paymentId);

	public List<PaymentsResponseDTO> getPaymentsByStatus(String statusStr);

}