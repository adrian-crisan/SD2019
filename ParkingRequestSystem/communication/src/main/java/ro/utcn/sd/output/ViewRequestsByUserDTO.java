package ro.utcn.sd.output;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@Getter
@Setter
public class ViewRequestsByUserDTO {

	private final long id;

	private final String date;
	
	private final String username;
	
	private final String state;
	
	private final String car;
	
	private final String parkingLot;
	
	
}
