package ovh.crow.guesswho;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {
        @Index(value = "imgName, name", unique = true)
})
public class Person {

    @Id
    private long id;

    @NotNull
    private String imgName;
    private String name;
@Generated(hash = 1210556999)
public Person(long id, @NotNull String imgName, String name) {
    this.id = id;
    this.imgName = imgName;
    this.name = name;
}
@Generated(hash = 1024547259)
public Person() {
}
public long getId() {
    return this.id;
}
public void setId(long id) {
    this.id = id;
}
public String getImgName() {
    return this.imgName;
}
public void setImgName(String imgName) {
    this.imgName = imgName;
}
public String getName() {
    return this.name;
}
public void setName(String name) {
    this.name = name;
}
}
