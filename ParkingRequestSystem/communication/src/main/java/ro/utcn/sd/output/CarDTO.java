package ro.utcn.sd.output;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@Getter
@Setter
public class CarDTO {

	private final String vin;
	private final String pti;
	private final String username;
	
}
