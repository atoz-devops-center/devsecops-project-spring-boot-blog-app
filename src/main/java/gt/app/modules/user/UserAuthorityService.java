package gb.app.modules.user;

import gb.app.config.security.AppUserDetails;
import gb.app.domain.AppUser;
import gb.app.domain.Note;
import gb.app.modules.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("appSecurity")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserAuthorityService {

    private final NoteService noteService;

    public boolean hasAccess(AppUserDetails curUser, Long id, String entity) {

        if (curUser.isSystemAdmin()) {
            return true;
        }

        if (AppUser.class.getSimpleName().equalsIgnoreCase(entity)) {
            return id.equals(curUser.getId());
        }


        if (Note.class.getSimpleName().equalsIgnoreCase(entity)) {

            Long createdById = noteService.findCreatedByUserIdById(id);

            return createdById.equals(curUser.getId());
        }


        /*
        add more rules
         */

        return false;
    }

}
