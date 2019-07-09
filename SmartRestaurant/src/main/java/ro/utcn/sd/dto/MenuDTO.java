package ro.utcn.sd.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class MenuDTO {

	public final String name;
	public final double price;
	public final String type;
}
