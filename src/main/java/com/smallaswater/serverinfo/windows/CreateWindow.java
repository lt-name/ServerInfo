package com.smallaswater.serverinfo.windows;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.TextFormat;
import com.smallaswater.serverinfo.ServerInfoMainClass;
import com.smallaswater.serverinfo.servers.ServerInfo;

/**
 * @author SmallasWater
 * Create on 2021/7/14 9:14
 * Package com.smallaswater.serverinfo.windows
 */
public class CreateWindow {

    public static final int MENU = 0x55011;

    public static void showMenu(Player player){
        FormWindowSimple simple = new FormWindowSimple(TextFormat.colorize('&',
                ServerInfoMainClass.getInstance().getLanguage().getString("menu-title"))
                ,TextFormat.colorize('&',
                ServerInfoMainClass.getInstance().getLanguage().getString("menu-text").replace("{sum}",
                        ServerInfoMainClass.getInstance().getAllPlayerSize()+"")));
        for(ServerInfo info: ServerInfoMainClass.getInstance().getServerInfos()){
            simple.addButton(new ElementButton(TextFormat.colorize('&',info.toButtonText())
                    ,new ElementButtonImageData("path","textures/ui/icon_new")));
        }
        player.showFormWindow(simple,MENU);

    }
}
