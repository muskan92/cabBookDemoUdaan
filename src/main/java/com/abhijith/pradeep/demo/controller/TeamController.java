package com.abhijith.pradeep.demo.controller;

import com.abhijith.pradeep.demo.entry.Team;
import com.abhijith.pradeep.demo.manager.TeamManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/team/{teamId}")
public class TeamController {

    @Autowired
    private TeamManager teamManager;

    @GetMapping(path = "/")
    public Team getTeam(@PathVariable("teamId") String teamId) {
        return teamManager.getTeam(teamId);
    }

    @PutMapping()
    public void createTeam(@PathVariable("teamId") String teamId, @RequestBody List<String> playerIds) {
        teamManager.createTeam(teamId, playerIds);
    }
}
