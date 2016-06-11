# The client user execution script for Project Two - CNT 4714 - Summer 2016
# all commands assumed to be executed by the client user
# the client user has only selection  privilege on the project2 database schema
#
#Command 1:
#   Query: Which rider won Paris-Roubaix in 1972?
select ridername
from racewinners
where racename = 'Paris-Roubaix' and raceyear = 1972;

#Command 2:
#   Delete all the riders from Norway from the riders table.
#   * * * Do a "before" and "after" select * from riders for this command.
#   Note: the before and after select statements will execute, but the delete will not
#         thus no changes will be reflected in the before and after snapshots.
select * from riders;
delete from riders where nationality = 'Norway';
select * from riders;

#Command 3:
#    Update rider Mark Renshaw to show number of wins = 40 in the riders table.
# * * Do a "before" and "after" selection on the riders table
#   Note: the before and after select statements will execute, but the delete will not
#         thus no changes will be reflected in the before and after snapshots.
select * from riders;
update riders set num_pro_wins = 40 where ridername = "Mark Renshaw";
select * from riders;
