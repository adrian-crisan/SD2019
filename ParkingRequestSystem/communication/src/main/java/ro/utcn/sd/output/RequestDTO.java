package ro.utcn.sd.output;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@Getter
@Setter
public class RequestDTO implements DTO {

	private final String date;
	private final String username;
	private final String state;
	private final String carVin;
	private final String parkingLot;
}
