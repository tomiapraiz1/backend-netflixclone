package clone.netflix.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

import java.util.List;

public record MovieDTO (
        Long id,
        String name,
        int duration,
        List<String> genres,
        String description
) {
}
