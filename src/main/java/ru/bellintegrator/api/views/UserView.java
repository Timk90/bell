package ru.bellintegrator.api.views;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.api.model.Country;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.PersonalDoc;

@ApiModel(description = "Сотрудник")
public class UserView {
	
	@NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
	private long id;

	@Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
	private String firstName;

	@Size(max = 50)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
	
	private String secondName;
	@Size(max = 50)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
	private String middleName;

	@Size(max = 50)
    @NotEmpty(message = "position cannot be null")
    @ApiModelProperty(value = "должность", example = "менеджер")
	private String position;

	@Size(max = 50)
    @ApiModelProperty(value = "Телефон", example = "9323199813")
	private String phone;

	private PersonalDoc personalDocument;

	private Office office;

	private Country citizenship;

	private boolean isIdentified;
	

    @Override
    public String toString() {
        return "{id:" + id + 
        		"officeId:"+ office.getId()+
        		";firstname:" + firstName + 
        		";secondName:" + secondName + 
        		";middleName:" + middleName +
        		";position:"+ position+
        		";phone" + phone+
        		";docName:" + personalDocument.getDocument().getName()+
        		";docNumber:" +personalDocument.getNumber()+
        		";docDate:"+personalDocument.getDocDate().toString()+
        		";citizenship:"+citizenship.getName()+
        		";isidentified:"+isIdentified+
        		"}";
    }

}
