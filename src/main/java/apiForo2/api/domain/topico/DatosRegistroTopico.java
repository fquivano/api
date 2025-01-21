package apiForo2.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
      @NotBlank String titulo,
      @NotBlank String mensaje,
      @NotNull Status status,
      @NotBlank String autor,
      @NotBlank String curso

) {
}
