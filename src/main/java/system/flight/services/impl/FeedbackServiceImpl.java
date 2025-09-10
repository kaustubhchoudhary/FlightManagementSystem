package system.flight.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import system.flight.dto.ApiResponseDTO;
import system.flight.dto.FeedbackDTO;
import system.flight.entities.Feedback;
import system.flight.entities.Passenger;
import system.flight.exception.ResourceNotFoundException;
import system.flight.repository.FeedbackRepository;
import system.flight.repository.PassengerRepository;
import system.flight.services.FeedbackService;

import java.time.LocalDateTime;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public ApiResponseDTO<FeedbackDTO> submitFeedback(FeedbackDTO dto) {
		Passenger passenger = passengerRepository.findById(dto.getPassengerId())
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not found"));

		Feedback feedback = new Feedback();
		feedback.setPassenger(passenger);
		feedback.setFeedbackTime(LocalDateTime.now()); // Automatically set current time
		feedback.setFeedbackMessage(dto.getFeedbackMessage());

		Feedback savedFeedback = feedbackRepository.save(feedback);
		dto.setFeedbackId(savedFeedback.getFeedbackId());
		dto.setFeedbackTime(savedFeedback.getFeedbackTime()); // Return the actual saved time

		return new ApiResponseDTO<>(HttpStatus.OK.value(), "Feedback submitted successfully", dto);
	}

	@Override
	public ApiResponseDTO<Feedback> getFeedback(int feedbackId) {
		Feedback feedback = feedbackRepository.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("Feedback not found"));

		return new ApiResponseDTO<>(HttpStatus.OK.value(), "Feedback fetched successfully", feedback);
	}

	@Override
	public ApiResponseDTO<Void> deleteFeedback(int feedbackId) {
		Feedback feedback = feedbackRepository.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("Feedback not found"));

		feedbackRepository.delete(feedback);

		return new ApiResponseDTO<>(HttpStatus.OK.value(), "Feedback deleted successfully", null);
	}
}
