package com.aws.pocketmoney.menu.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "MENU_LIST")
@Entity
@ToString
public class MenuVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN_SEQ")
    private long snSeq;
    @Column(name = "MENU_NAME")
    private String menuName;
    @Column(name = "MENU_CODE")
    private String menuCode;
    @Column(name = "MENU_ICON")
    private String menuIcon;
    @Column(name="MENU_ORDER")
    private long menuOrder;
    @Column(name="MENU_PATH")
    private String menuPath;
    @Column(name="MENU_ROUTER")
    private String menuRouter;

}
