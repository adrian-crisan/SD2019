package ro.utcn.sd.output;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@Getter
@Setter
public class UserDTO implements DTO{

	private final Long userid;
    @NonNull private final String username;
    @NonNull private final String password;
    @NonNull private final String email;
    @NonNull private final String name;
    private final boolean isAdmin;

}
