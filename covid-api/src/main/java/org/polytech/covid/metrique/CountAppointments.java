//package org.polytech.covid.metrique;
//
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.core.instrument.Tag;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.metrics.StartupStep;
//
//public class CountAppointments {
//  private final MeterRegistry registry;
//
//  @Autowired
//  public CountAppointments(MeterRegistry registry) {
//    this.registry = registry;
//  }
//
//  @AfterReturning("execution(public * ReservationService.addnewReservation(..))")
//  public void succes(JoinPoint joinPoint) {
//    StartupStep.Tag tag = Tag.of("miner-impl", joinPoint.getTarget().getClass().getSimpleName());
//    registry.counter("bitcoin-mined", List.of(tag)).increment();
//  }
//}
