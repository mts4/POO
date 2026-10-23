package Vista;

import Controlador.ResultadoController;
import Controlador.SessionController;
import Modelo.Estadisticas;
import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticas {

	private SessionController session;
	private JFrame frame;

	public VentanaEstadisticas(SessionController session) {
		this.session = session;
	}

	public void mostrarVentana() {
		ResultadoController controller = new ResultadoController(this.session);
		Estadisticas stats = controller.obtenerEstadisticas();

		frame = new JFrame("Estadísticas del Jugador");
		frame.setSize(350, 300);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(6, 1));

		String tipoTexto = (stats.getTipoMasJugado() != null) ? stats.getTipoMasJugado().toString() : "Sin datos";

		frame.add(new JLabel("  Total de Jugadas: " + stats.getTotalJugadas()));
		frame.add(new JLabel("  Victorias Totales: " + stats.getVictorias()));
		frame.add(new JLabel("  Porcentaje de Victoria: " + String.format("%.2f", stats.getPorcentajeVictorias()) + "%"));
		frame.add(new JLabel("  Racha Máxima: " + stats.getRachaMaxima()));
		frame.add(new JLabel("  Apuesta Favorita: " + tipoTexto));

		frame.setVisible(true);
	}
}
