package unam.diplomado.pixup.usuarioservice.service;

import unam.diplomado.pixup.usuarioservice.domain.Estado;

public interface EstadoService {
	//Esto es un  API nuestros servicios REST para clientes que lo consumen remotamente, 
	//FIRMA O CONTRATO, ENTRADA SALIDA Notificacion error
	Estado actualizarEstado(String id,Estado estado);
	
	
}
