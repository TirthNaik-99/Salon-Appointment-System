package com.tirth.paymentservice.controller;


import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.tirth.paymentservice.domain.PaymentMethod;
import com.tirth.paymentservice.modal.PaymentOrder;
import com.tirth.paymentservice.payload.dto.BookingDTO;
import com.tirth.paymentservice.payload.dto.UserDTO;
import com.tirth.paymentservice.payload.response.PaymentLinkResponse;
import com.tirth.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@RequestBody BookingDTO booking,
                                                                 @RequestParam PaymentMethod paymentMethod) throws StripeException, RazorpayException {

        UserDTO user = new UserDTO();
        user.setFullName("Tirth");
        user.setEmail("tirth@gmail.com");
        user.setId(1L);

        PaymentLinkResponse res = paymentService.createOrder(user, booking, paymentMethod);
        return ResponseEntity.ok(res);

    }

    @GetMapping("/create")
    public ResponseEntity<PaymentOrder> getPaymentOrderById(@PathVariable Long paymentOrderId) throws Exception {
        PaymentOrder res = paymentService.getPaymentOrderById(paymentOrderId);
        return ResponseEntity.ok(res);

    }

    @PatchMapping("/proceed")
    public ResponseEntity<Boolean> proceedPayment(@RequestParam String paymentId,
                                                       @RequestParam String paymentLinkId) throws Exception {
        PaymentOrder paymentOrder = paymentService.getPaymentOrderByPaymentId(paymentLinkId);

        Boolean res = paymentService.proceedPayment(paymentOrder, paymentId, paymentLinkId);
        return ResponseEntity.ok(res);

    }
}
