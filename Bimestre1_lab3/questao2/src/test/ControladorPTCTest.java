package test;

//import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void testConstructor() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = spy(Datacenter.class);
		PainelCondutor painelCond = spy(PainelCondutor.class);
		
		when(sensor.getVelocidade()).thenReturn(10.0);
		when(sensor.isCruzamento()).thenReturn(true);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);

		//testando se sensor e painelCond foram inicializados corretamente
		when(painelCond.imprimirAviso("Velocidade Baixa", 1)).thenReturn(false);
		controladorPTC.run();
		verify(painelCond).aceleraVelocidadeTrem(20);
		
		//testando se dataCenter foi inicializado correntamente
		when(sensor.isCruzamento()).thenReturn(false);
		ControladorPTC controladorPTC2 = new ControladorPTC(sensor, dataCenter, painelCond);
		controladorPTC2.run();
		verify(dataCenter).gerarRelatorio();
	}
	
	@Test
	void testNaoEhCruzamento() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = mock(Datacenter.class);
		PainelCondutor painelCond = mock(PainelCondutor.class);
		
		when(sensor.isCruzamento()).thenReturn(false);
		when(sensor.getVelocidade()).thenReturn(10.0);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		controladorPTC.run();
		
		verify(painelCond).imprimirAviso((new Double(sensor.getVelocidade())).toString(), 1);
		verify(dataCenter).gerarRelatorio();;
	}

	@Test
	void testVelocidadeAltaCruzamento() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = spy(Datacenter.class);
		PainelCondutor painelCond = mock(PainelCondutor.class);
		
		when(sensor.isCruzamento()).thenReturn(true);
		when(sensor.getVelocidade()).thenReturn(120.0);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		when(painelCond.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
		controladorPTC.run();
		
		verify(painelCond).imprimirAviso("Velocidade alta", 1);
	}
	
	@Test
	void testVelocidadeBaixaCruzamento() {
		Sensor sensor = spy(Sensor.class);
		Datacenter dataCenter = spy(Datacenter.class);
		PainelCondutor painelCond = mock(PainelCondutor.class);
		
		when(sensor.isCruzamento()).thenReturn(true);
		when(sensor.getVelocidade()).thenReturn(10.0);
		
		ControladorPTC controladorPTC = new ControladorPTC(sensor, dataCenter, painelCond);
		when(painelCond.imprimirAviso("Velocidade Baixa", 1)).thenReturn(false);
		controladorPTC.run();
		
		verify(painelCond).aceleraVelocidadeTrem(20);
	}
}
