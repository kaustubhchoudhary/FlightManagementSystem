package system.flight.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.flight.dto.PaymentsResponseDTO;
import system.flight.entities.Payment;
import system.flight.entities.User;
import system.flight.enums.PaymentStatus;
import system.flight.exception.ResourceNotFoundException;
import system.flight.mapper.PaymentMapper;
import system.flight.repository.PaymentRepository;
import system.flight.services.PaymentService;
import system.flight.services.UserService;
import system.flight.utility.OwnershipUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private UserService userService;

	@Override
	public List<Payment> getAllPayments() {

		return paymentRepository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		User currentUser = userService.getCurrentAuthenticatedUser();

		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

		OwnershipUtils.validateOwnership(payment.getUser(), currentUser);

		return payment;
	}

	@Override
	public List<PaymentsResponseDTO> getPaymentsByStatus(String statusStr) {
		try {
			PaymentStatus status = PaymentStatus.valueOf(statusStr.toUpperCase());
			User currentUser = userService.getCurrentAuthenticatedUser();

			return paymentRepository.findByPaymentStatus(status).stream().filter(payment -> {
				User paymentUser = payment.getUser();
				OwnershipUtils.validateOwnership(paymentUser, currentUser);
				return true;
			}).map(PaymentMapper::toDTO).toList();

		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Invalid payment status: " + statusStr);
		}
	}

}
