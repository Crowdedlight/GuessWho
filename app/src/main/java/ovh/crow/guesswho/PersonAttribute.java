package ovh.crow.guesswho;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Frederik Mazur Andersen on 19-03-2017.
 */

@Entity
public class PersonAttribute {
    @Id
    private long id;

    @NotNull
    private long PersonID;
    @NotNull
    private long AttributeID;
}
