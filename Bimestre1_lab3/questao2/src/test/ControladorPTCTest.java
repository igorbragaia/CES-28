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
		assertEquals(1,1);
	}
	
	@Test
	void testNaoEhCruzamento() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = spy(Datacenter.class);
		PainelCondutor painelCond = spy(PainelCondutor.class);
		
		when(sensor.isCruzamento()).thenReturn(false);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		controladorPTC.run();
//		enviaMsgDatacenter(new Double(velocidade), dataCenter);
//		enviaMsgNormalPainel(new Double(velocidade), painelCond);
		assertEquals(false, sensor.isCruzamento());
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
	}
}
