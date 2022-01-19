package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangqiang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;
    private String description;
}
