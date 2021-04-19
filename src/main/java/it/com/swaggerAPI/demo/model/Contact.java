package it.com.swaggerAPI.demo.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "contact")
public class Contact {
    @ApiModelProperty( name = "id", notes = "Unique id of contact", required = true, example = "1")
    private Integer id;

    @ApiModelProperty(name = "name", notes = "Name of contact", required = true, example = "Pippo")
    private String name;
}
