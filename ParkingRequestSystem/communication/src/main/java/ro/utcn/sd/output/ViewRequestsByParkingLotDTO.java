package ro.utcn.sd.output;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ViewRequestsByParkingLotDTO implements DTO {

	private final List<RequestDTO> requests;
}
