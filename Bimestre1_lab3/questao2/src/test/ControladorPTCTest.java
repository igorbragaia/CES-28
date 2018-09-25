package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mock.ControladorPTC;
import mock.Datacenter;
import mock.PainelCondutor;
import mock.Sensor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class ControladorPTCTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConstructor() {
		Sensor sensor = mock(Sensor.class);
		Datacenter dataCenter = mock(Datacenter.class);
		PainelCondutor painelCond = mock(PainelCondutor.class);
		
		when(sensor.getVelocidade()).thenReturn(20.0);
		when(sensor.isCruzamento()).thenReturn(true);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		//FALTA O TESTE DO CONSTRUTOR
	}
	
	@Test
	void testNaoEhCruzamento() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = spy(Datacenter.class);
		PainelCondutor painelCond = spy(PainelCondutor.class);
		
		when(sensor.isCruzamento()).thenReturn(false);
		when(sensor.getVelocidade()).thenReturn(10.0);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		controladorPTC.run();
//		verify(controladorPTC).run();
//		enviaMsgDatacenter(new Double(velocidade), dataCenter);
//		enviaMsgNormalPainel(new Double(velocidade), painelCond);
		verify(controladorPTC).enviaMsgDatacenter(new Double(10.0), dataCenter);
		verify(controladorPTC).enviaMsgNormalPainel(new Double(10.0), painelCond);
	}

	@Test
	void testVelocidadeAltaCruzamento() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = spy(Datacenter.class);
		PainelCondutor painelCond = spy(PainelCondutor.class);
		
		when(sensor.isCruzamento()).thenReturn(true);
		when(sensor.getVelocidade()).thenReturn(120.0);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		
		when(controladorPTC.enviaMsgPrioritariaPainel("Velocidade alta", painelCond)).thenReturn(true);
		controladorPTC.run();
		
//		boolean result = enviaMsgPrioritariaPainel("Velocidade alta", painelCond);
		verify(controladorPTC).enviaMsgPrioritariaPainel("Velocidade alta", painelCond);
	}
	
	@Test
	void testVelocidadeBaixaCruzamento() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = spy(Datacenter.class);
		PainelCondutor painelCond = spy(PainelCondutor.class);
		
		when(sensor.isCruzamento()).thenReturn(false);
		when(sensor.getVelocidade()).thenReturn(10.0);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		
		when(controladorPTC.enviaMsgPrioritariaPainel("Velocidade Baixa", painelCond)).thenReturn(true);
		controladorPTC.run();
		
//		aumentaVelocidade(20);
		verify(controladorPTC).aumentaVelocidade(20);
	}
}
